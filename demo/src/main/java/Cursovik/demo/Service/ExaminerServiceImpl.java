package Cursovik.demo.Service;

import Cursovik.demo.Exeptions.NotEnoughQuestionExeption;
import Cursovik.demo.Question;
import org.springframework.stereotype.Service;

import javax.management.openmbean.CompositeData;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {


    @Override
    public Collection<Question> getQuestions(int amount) {
        JavaQuestionService service;
        var allQuestions = service.getAll();
        if (amount > allQuestions.size()) {
            throw new NotEnoughQuestionExeption();
        }

        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(service.getRandomQuestion());
        }
        return result;
    }
}
