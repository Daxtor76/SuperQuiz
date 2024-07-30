package com.example.superquiz.ui.quiz;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.superquiz.data.Question;
import com.example.superquiz.data.QuestionRepository;

import java.util.List;

public class QuizViewModel extends ViewModel
{
    private QuestionRepository questionRepository;
    private List<Question> questions;
    private int currentQuestionIndex = 0;

    MutableLiveData<Question> currentQuestion = new MutableLiveData<Question>();
    MutableLiveData<Boolean> isLastQuestion = new MutableLiveData<Boolean>(false);
    MutableLiveData<Integer> score = new MutableLiveData<Integer>(0);

    public QuizViewModel(QuestionRepository questionRepository)
    {
        this.questionRepository = questionRepository;
    }

    public void startQuiz()
    {
        questions = questionRepository.getQuestions();
        currentQuestion.postValue(questions.get(currentQuestionIndex));
    }

    public boolean isAnswerValid(int answerIndex)
    {
        boolean valid = currentQuestion.getValue().getAnswerIndex() == answerIndex;
        Integer currentScore = score.getValue();

        if (currentScore != null && valid)
            score.setValue(currentScore + 1);

        return valid;
    }

    public void nextQuestion()
    {
        int nextIndex = currentQuestionIndex + 1;
        int maxIndex = questions.size() - 1;

        if (nextIndex >= maxIndex)
        {
            isLastQuestion.postValue(true);
        }
        else
        {
            currentQuestion.postValue(questions.get(nextIndex));
            currentQuestionIndex = nextIndex;
        }
    }
}
