package br.com.Personal.Assist.dto.feedback;

import br.com.Personal.Assist.model.feedback.Feedback;

public record DetalhesFeedback(Long codigo, Integer nota, String positivo, String negativo) {

    public DetalhesFeedback(Feedback feedback){
        this(feedback.getCodigo(), feedback.getNota(), feedback.getPositivo(), feedback.getNegativo());
    }
}
