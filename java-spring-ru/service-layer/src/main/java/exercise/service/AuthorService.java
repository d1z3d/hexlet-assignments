package exercise.service;

import exercise.dto.*;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.mapper.BookMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public List<AuthorDTO> getAll() {
        var books = authorRepository.findAll();
        return books.stream()
                .map(authorMapper::map)
                .toList();
    }

    public AuthorDTO findById(Long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        return authorMapper.map(author);
    }

    public AuthorDTO create(AuthorCreateDTO authorData) {
        var author = authorMapper.map(authorData);
        authorRepository.save(author);
        return authorMapper.map(author);
    }

    public AuthorDTO update(Long id, AuthorUpdateDTO bookData) {
        var book = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        authorMapper.update(bookData, book);
        authorRepository.save(book);
        return authorMapper.map(book);
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }


    // END
}
