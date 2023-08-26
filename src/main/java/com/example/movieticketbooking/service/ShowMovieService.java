package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.RoleEntity;
import com.example.movieticketbooking.entity.ShowMovieEntity;
import com.example.movieticketbooking.payload.response.RoleResponse;
import com.example.movieticketbooking.payload.response.ShowMovieResponse;
import com.example.movieticketbooking.repository.ShowMovieRepository;
import com.example.movieticketbooking.service.imp.IShowMovieService;
import com.example.movieticketbooking.utils.DateHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowMovieService implements IShowMovieService {
    @Autowired
    ShowMovieRepository showMovieRepository;

    @Override
    public List<ShowMovieResponse> getAllShowMovie() {
        List<ShowMovieEntity> showMovieEntityList = showMovieRepository.findAll();
        List<ShowMovieResponse> showMovieResponseList = new ArrayList<ShowMovieResponse>();

        for(ShowMovieEntity entity : showMovieEntityList){
            ShowMovieResponse showMovieResponse = new ShowMovieResponse();
            showMovieResponse.setId(entity.getId());
            showMovieResponse.setMovie(entity.getMovie().getName());
            showMovieResponse.setCinema(entity.getCinema().getName());

            DateHelperUtils dateHelperUtils = new DateHelperUtils();
            showMovieResponse.setDate(dateHelperUtils.formatDateToString(entity.getDate()));

            showMovieResponse.setStartTime(entity.getStartTime().toString());

            showMovieResponse.setState(entity.getStateShow());

            showMovieResponseList.add(showMovieResponse);
        }

        return showMovieResponseList;
    }
}
