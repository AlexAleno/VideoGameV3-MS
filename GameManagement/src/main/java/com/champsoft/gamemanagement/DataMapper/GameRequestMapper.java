package com.champsoft.gamemanagement.DataMapper;

import com.example.videogamev3.GameManagement.DataAccess.Game;
import com.example.videogamev3.GameManagement.DataAccess.GameId;
import com.example.videogamev3.GameManagement.DataAccess.Genre;
import com.example.videogamev3.GameManagement.Presentation.DTOS.GameRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class, GameRequestModel.class, GameId.class, LocalDateTime.class, Genre.class})
public interface GameRequestMapper {
    @Mapping(target = "gameId", expression = "java(new GameId(UUID.randomUUID().toString()))")
    @Mapping(target = "releaseDate", expression = "java(LocalDateTime.now())")
    @Mapping(target = "genre", expression = "java(Genre.valueOf(gameRequestModel.getGenre()))")
    Game gameRequestModelToGame(GameRequestModel gameRequestModel);
    List<Game> gameRequestModelToGame(List<GameRequestModel> gameRequestModels);
}
