package br.com.Personal.Assist.repository.application.feedback;

import br.com.Personal.Assist.model.application.feedback.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
