package com.mydaoexample.sobes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import jakarta.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Entity
class Student {
    @Id
    String id;
    String group;
    @OneToMany
    List<Book> books;
}

@Entity
class Book {
    @Id
    String id;
    String name;
}

@Repository
interface StudentRepository extends CrudRepository<Student, String> {
    List<Student> findStudentByGroup(String group);
}

@Service
class StudentService {
    @Autowired StudentRepository repository;

    String mostPopularBook(String group) {
        return repository.findStudentByGroup(group)
                .stream()
                .flatMap(s -> s.books.stream())
                .collect(Collectors.groupingBy(book -> book.name, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .get();
    }

}

