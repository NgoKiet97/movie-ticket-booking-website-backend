package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.*;
import com.example.movieticketbooking.payload.request.ShowMovieRequest;
import com.example.movieticketbooking.payload.response.ShowMovieResponse;
import com.example.movieticketbooking.repository.RoomRepository;
import com.example.movieticketbooking.repository.ShowMovieRepository;
import com.example.movieticketbooking.service.imp.IShowMovieService;
import com.example.movieticketbooking.utils.DateHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShowMovieService implements IShowMovieService {
    @Autowired
    ShowMovieRepository showMovieRepository;

    @Autowired
    RoomRepository roomRepository;


    @Override
    public List<ShowMovieResponse> getAllShowMovie() {
        List<ShowMovieEntity> showMovieEntityList = showMovieRepository.findAll();
        List<ShowMovieResponse> showMovieResponseList = new ArrayList<ShowMovieResponse>();

        for(ShowMovieEntity entity : showMovieEntityList){
            ShowMovieResponse showMovieResponse = new ShowMovieResponse();
            showMovieResponse.setId(entity.getId());
            showMovieResponse.setMovie(entity.getMovie().getName());

            showMovieResponse.setRoom(entity.getRoomEntity().getName());
            showMovieResponse.setCinema(entity.getRoomEntity().getCinema().getName());

            DateHelperUtils dateHelperUtils = new DateHelperUtils();
            showMovieResponse.setDate(dateHelperUtils.formatDateToString(entity.getDate()));

            showMovieResponse.setStartTime(entity.getStartTime().toString());
            showMovieResponse.setState(entity.getStateShow());

            showMovieResponseList.add(showMovieResponse);
        }

        return showMovieResponseList;
    }

    @Override
    public boolean addShowMovie(ShowMovieRequest showMovieRequest) {
        try{
            ShowMovieEntity showMovieEntity = new ShowMovieEntity();

            DateHelperUtils dateHelperUtils = new DateHelperUtils();
            showMovieEntity.setDate(dateHelperUtils.formatStringToDate(showMovieRequest.getDate()));

            showMovieEntity.setStartTime(LocalTime.parse(showMovieRequest.getStartTime()));
            showMovieEntity.setStateShow(showMovieRequest.getState());

            MovieEntity movieEntity = new MovieEntity();
            movieEntity.setId(showMovieRequest.getMovieId());
            showMovieEntity.setMovie(movieEntity);

            RoomEntity roomEntity = new RoomEntity();
            roomEntity.setId(showMovieRequest.getRoomId());
            showMovieEntity.setRoomEntity(roomEntity);

            showMovieRepository.save(showMovieEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<ShowMovieResponse> getShowMovieByCinemaAndDateAndStateShow(int cinemaId, String date, String stateShow) throws ParseException {
        List<ShowMovieResponse> showMovieResponseList = new ArrayList<ShowMovieResponse>();
        List<RoomEntity> roomEntityList = roomRepository.findByCinemaId(cinemaId);
        DateHelperUtils dateHelperUtils = new DateHelperUtils();

        for(RoomEntity roomEntity : roomEntityList) {
            List<ShowMovieEntity> showMovieEntityList = showMovieRepository.findByRoomEntityAndDateAndStateShow(roomEntity, dateHelperUtils.formatStringToDate(date), stateShow);
            for(ShowMovieEntity entity : showMovieEntityList){
                ShowMovieResponse showMovieResponse = new ShowMovieResponse();
                showMovieResponse.setId(entity.getId());
                showMovieResponse.setMovie(entity.getMovie().getName());

                showMovieResponse.setRoom(entity.getRoomEntity().getName());
                showMovieResponse.setCinema(entity.getRoomEntity().getCinema().getName());

                showMovieResponse.setDate(dateHelperUtils.formatDateToString(entity.getDate()));

                showMovieResponse.setStartTime(entity.getStartTime().toString());
                showMovieResponse.setState(entity.getStateShow());

                showMovieResponseList.add(showMovieResponse);
            }
        }

        return showMovieResponseList;
    }
}
