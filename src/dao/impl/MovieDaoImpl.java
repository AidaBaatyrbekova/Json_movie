package dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.MovieDao;
import model.Movie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class MovieDaoImpl implements MovieDao {
    // TODO: 14.09.2023 положить фильм в указанной JSON файл
    @Override
    public void writeToFile(String path, List<Movie> movies) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.writeValue(new File(path), movies);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO: 14.09.2023 вернуть список фильмов из JSON файла (путь указан в параметре метода)
    @Override
    public List<Movie> readFromFile(String path) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            reader.close();
            TypeReference<List<Movie>> typeReference = new TypeReference<>(){};
            return mapper.readValue(json.toString(), typeReference);

        } catch (IOException e) {
            return null;
        }
    }
}
