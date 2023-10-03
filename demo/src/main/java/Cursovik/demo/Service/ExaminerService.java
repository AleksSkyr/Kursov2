package Cursovik.demo.Service;

import Cursovik.demo.Question;
import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
