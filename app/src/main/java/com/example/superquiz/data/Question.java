package com.example.superquiz.data;

import java.util.List;

public class Question
{
    private final String question;
    private final List<String> choiceList;
    private final int answerIndex;

    public Question(String question, List<String> choiceList, int answerIndex)
    {
        this.question = question;
        this.choiceList = choiceList;
        this.answerIndex = answerIndex;
    }

    public int getAnswerIndex()
    {
        return answerIndex;
    }

    public List<String> getChoiceList()
    {
        return choiceList;
    }

    public String getQuestion()
    {
        return question;
    }
}
