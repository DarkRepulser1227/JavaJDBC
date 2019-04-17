package Controller;


import Utils.Tools;
import View.systemView;

public class stuentSystem {

    public stuentSystem() {
        while (true){
            systemView.systemView();
            int Choise = Tools.getNum(systemView.viewIn());
            if (Choise == 0){
                systemView.viewOut("谢谢使用,下次再见.");
                break;
            }else{
                switch (Choise){
                    case 1:
                        studentZSGC.insertStudent();
                        break;
                    case 2:
                        studentZSGC.findAll();
                        break;
                    case 3:
                        studentZSGC.findSomeoneByName();
                        break;
                    case 4:
                        studentZSGC.update();
                        break;
                    case 5:
                        studentZSGC.delete();
                        break;
                    default:
                        systemView.viewOut("请输入正确数字.");
                }
            }


        }
    }
}
