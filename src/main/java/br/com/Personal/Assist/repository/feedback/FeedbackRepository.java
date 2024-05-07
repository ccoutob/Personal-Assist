package br.com.Personal.Assist.repository.feedback;

import br.com.Personal.Assist.model.feedback.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
