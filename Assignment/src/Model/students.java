package Model;

public class students {
    private int s_id;
    private String s_name;
    private String s_major;
    private Double s_score;

    public students() {
        s_major=null;
        s_score=null;
    }

    public students(int s_id, String s_name, String s_major, Double s_score) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_major = s_major;
        this.s_score = s_score;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        /**
         * ID不可为负
         */
        if (s_id < 0){
            System.out.println("请输入合法的id");
            return;
        }
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        if (s_name != "") {
            this.s_name = s_name;
        } else {
            System.out.println("名字禁止为空");
            return;
        }
    }

    public String getS_major() {
        return s_major;
    }

    public void setS_major(String s_major) {
        if (s_major != "") {
            this.s_major = s_major;
        } else {
            System.out.println("专业禁止为空");
            return;
        }
    }

    public Double getS_score() {
        return s_score;
    }

    public void setS_score(Double s_score) {
        if (s_score < 0){
            System.out.println("请输入合法的数值");
            return;
        }else if (s_score == null){
            System.out.println("分数禁止为空");
        }else {
            this.s_score = s_score;
        }

    }

    @Override
    public String toString() {
        return "students{" +
                "s_id=" + s_id +
                ", s_name='" + s_name + '\'' +
                ", s_major='" + s_major + '\'' +
                ", s_score=" + s_score +
                '}';
    }
}
