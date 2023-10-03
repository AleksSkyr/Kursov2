package Cursovik.demo.Service;

import Cursovik.demo.Exeptions.QuestionsNotFound;
import Cursovik.demo.Question;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JavaQuestionService implements QuestionService {

    private final Random random = new Random();
    private final Set<Question> questions = new HashSet<>();


    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);

    }

    @Override
    public Question getRandomQuestion() {
        var index = random.nextInt(questions.size());
        int q = 0;
        var it = questions.iterator();
        while (it.hasNext()) {
            if (q == index) {
                return it.next();
            }
            q++;
        }
        throw new QuestionsNotFound();
    }
}
