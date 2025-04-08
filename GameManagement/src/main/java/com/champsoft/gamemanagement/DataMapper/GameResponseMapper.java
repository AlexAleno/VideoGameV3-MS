package com.champsoft.gamemanagement.DataMapper;

import com.example.videogamev3.GameManagement.DataAccess.Game;
import com.example.videogamev3.GameManagement.DataAccess.GameId;
import com.example.videogamev3.GameManagement.DataAccess.Genre;
import com.example.videogamev3.GameManagement.Presentation.DTOS.GameRequestModel;
import com.example.videogamev3.GameManagement.Presentation.DTOS.GameResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring",imports = {UUID.class, GameRequestModel.class, GameId.class, LocalDateTime.class, Genre.class})
public interface GameResponseMapper {

    @Mapping(target = "id", expression = "java(game.getGameId().getUuid())")
    @Mapping(target = "releaseDate", expression = "java(game.getReleaseDate().toString())")
    @Mapping(target = "genre", expression = "java(game.getGenre().toString())")
    GameResponseModel gameToGameResponseModel(Game game);
    List<GameResponseModel> gameToGameResponseModel(List<Game> game);
}
