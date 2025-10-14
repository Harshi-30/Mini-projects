import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        QuestionService service = new QuestionService();
        service.playQuiz();
        service.printScore();
    }
}
class QuestionService {
    Question[] questions = new Question[5]; // it is just an declearerd array 
    String userAns[]=new String[5];
    public QuestionService (){
        questions[0] = new Question(1, "size of int", "2", "6", "4", "8", "4");
        questions[1] = new Question(2, "size of double", "2", "6", "4", "8", "8");
        questions[2] = new Question(3, "size of char", "2", "6", "4", "8", "2");
        questions[3] = new Question(4, "size of long", "2", "6", "4", "8", "8");
        questions[4] = new Question(5, "size of boolean", "1", "2", "4", "8", "1");
    }
    public void playQuiz(){
        int i = 0;
        for(Question q :questions ){
            System.out.println("Question No. "+q.getId());
            System.out.println(q.getQuestion());
            System.out.println(q.getOpt1());
            System.out.println(q.getOpt2());
            System.out.println(q.getOpt3());
            System.out.println(q.getOpt4());
            Scanner sr = new Scanner(System.in);
            userAns[i] =sr.nextLine();
            i++;
        }
        System.out.println();
//        for(Question q:questions){
//            System.out.println(q.getAnswer());
//        }
    }
    public void printScore(){
        int score = 0;
        for(int i = 0;i < questions.length;i++){
            Question q = questions[i];
            String actualAnswer = q.getAnswer();
            String userAnswer = userAns[i];

            if(actualAnswer .equals(userAnswer)){
                score++;
            }
        }
        System.out.println("Your Score is : "+score);

    }

}
class Question {
    private int id;
    private String question;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private String answer;

    public Question(int id,String question,String opt1,String opt2,String opt3,String opt4,String answer){
        this.id=id;
        this.question = question;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.answer = answer;

    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getQuestion(){
        return question;
    }
    public void setQuestion(String question){
        this.question = question;
    }
    public String getOpt1(){
        return opt1;
    }
    public void setOpt1(String opt1){
        this.opt1 = opt1;
    }
    public String getOpt2(){
        return opt2;
    }
    public void setOpt2(String opt2){
        this.opt2 = opt2;
    }
    public String getOpt3(){
        return opt3;
    }
    public void setOpt3(String opt3){
        this.opt3 = opt3;
    }
    public String getOpt4(){
        return opt4;
    }
    public void setOpt4(String opt4){
        this.opt4 = opt4;
    }
    public String getAnswer(){
        return answer;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question [id=" + id + ", question=" + question + ", opt1=" + opt1 + ", opt2=" + opt2 + ", opt3=" + opt3
                + ", opt4=" + opt4 + ", answer=" + answer + "]";
    }

}
