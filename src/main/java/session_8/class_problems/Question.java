abstract class Question {
    protected String text;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String text, String correctAnswer, String studentAnswer, double points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double grade();
    public abstract String getTypeName();
}

class MCQQuestion extends Question {
    public MCQQuestion(String text, String correctAnswer, String studentAnswer, double points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        if (studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) {
            return points;
        }
        return 0.0;
    }

    @Override
    public String getTypeName() {
        return "MCQ";
    }
}

class TFQuestion extends Question {
    public TFQuestion(String text, String correctAnswer, String studentAnswer, double points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        if (studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) {
            return points;
        }
        return 0.0;
    }

    @Override
    public String getTypeName() {
        return "TF";
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String text, String correctAnswer, String studentAnswer, double points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String lowerStudentAnswer = studentAnswer.toLowerCase();

        for (String kw : keywords) {
            String trimmedKw = kw.trim().toLowerCase();
            if (!trimmedKw.isEmpty() && lowerStudentAnswer.contains(trimmedKw)) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }

    @Override
    public String getTypeName() {
        return "ESSAY";
    }
}