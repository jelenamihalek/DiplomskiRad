package diplomski_rad.services;

import java.util.List;

import org.springframework.stereotype.Service;

import diplomski_rad.models.GenreModel;

@Service
public interface GenreService extends CrudService<GenreModel> {

	List<GenreModel>getGenresByName(String name);
}
