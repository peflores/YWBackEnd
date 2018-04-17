package com.weather.redbee.rest;

import com.weather.redbee.dot.BoardCityDTO;
import com.weather.redbee.dot.BoardDTO;
import com.weather.redbee.dot.CityDTO;
import com.weather.redbee.service.BoardCityService;
import com.weather.redbee.service.BoardService;
import com.weather.redbee.service.CityService;
import com.weather.redbee.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/serverSide")
public class ServiceRest {

    @Autowired
    private CityService cityService;
    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardCityService boardCityService;

    @Autowired
    Utilities utilities;

    @ResponseBody
    @RequestMapping(value = "{boardId}/addCity", method = RequestMethod.POST)
    public CityDTO addCity(@PathVariable("boardId") String idBoard, @RequestBody CityDTO city) {

        city.setDescription(utilities.getImgUrl(city.getDescription()));
        CityDTO newCity = cityService.findByLatAndLong(city.getLat(), city.getLon()).orElseGet(
                () -> {
                    city.setTimeLastQuery(utilities.getCurrentDateTime());
                    return cityService.add(city);
                }
        );
        boardCityService.add(new BoardCityDTO(null, idBoard,  newCity.getCityId()));
        return newCity;
    }

    @ResponseBody
    @RequestMapping(value = "{boardId}/allCity", method = RequestMethod.GET)
    public List<CityDTO> findCitysByBoard(@PathVariable("boardId") String idBoard) {
        return cityService.findByBoardId(idBoard);
    }

    @ResponseBody
    @RequestMapping(value = "/allBoards", method = RequestMethod.GET)
    public Iterable<BoardDTO> getAllBoard() { return boardService.findAll(); }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{boardId}/{cityId}", method = RequestMethod.DELETE)
    public void removeCityBoard(@PathVariable("boardId") String boardId,
                                @PathVariable("cityId") String cityId) {
        boardCityService.delete(new BoardCityDTO(null, boardId, cityId));
    }

    @RequestMapping(value = "/addBoard", method = RequestMethod.POST)
    @ResponseBody
    public BoardDTO addBoard(@RequestBody BoardDTO board) { return boardService.add(board); }

}
