package Controller;

import Model.students;
import Utils.DBTools;
import Utils.Tools;
import View.systemView;

import java.util.List;

/**
 * 完成所有学生的增删改查方法
 */
public class studentZSGC {
    public static void insertStudent(){
        systemView.viewOut("请输入新建学生的ID,必须为正整数.");
        students students = new students();
        String str = systemView.viewIn();
        students.setS_id(Tools.getNum(str));

        systemView.viewOut("请输入新建学生的名字,不可为空.");
        str = systemView.viewIn();
        students.setS_name(str);

        systemView.viewOut("请输入新建学生的专业,不可为空.");
        str = systemView.viewIn();
        students.setS_major(str);

        systemView.viewOut("请输入新建学生的分数,不可为空.");
        str = systemView.viewIn();
        students.setS_score(Tools.getDouble(str));
        //到此为止完成类的创建,下面进行插入操作.

        int flag = DBTools.insert(students);
        if (flag == 1) {
            systemView.viewOut("新建完成");
        } else {
            systemView.viewOut("新建失败,请检查数值是否正确,ID是否已经存在.");
        }
        //到此为止插入完成.Gao

    }

    public static void findAll(){

        List<students> list = DBTools.selectAll();

        systemView.viewOut(list.toString());

    }
    public static void findSomeoneByName(){
        systemView.viewOut("请输入要查询人的姓名,可以模糊查询.");
        String name = systemView.viewIn();
        systemView.viewOut(DBTools.selectSomeoneByName(name).toString());
    }

    public static void update(){
        systemView.viewOut("请输入更新学生的ID,必须为正整数.");
        students students = new students();
        String str = systemView.viewIn();
        students.setS_id(Tools.getNum(str));

        systemView.viewOut("请输入更新学生的名字,不可为空.");
        str = systemView.viewIn();
        students.setS_name(str);

        systemView.viewOut("请输入更新学生的专业,不可为空.");
        str = systemView.viewIn();
        students.setS_major(str);

        systemView.viewOut("请输入更新学生的分数,不可为空.");
        str = systemView.viewIn();
        students.setS_score(Tools.getDouble(str));

        int flag = DBTools.update(students);
        if (flag == 1) {
            systemView.viewOut("修改完成");
        } else {
            systemView.viewOut("修改失败,请检查数值是否正确,ID是否已经存在.");
        }

    }
    public static void delete(){
        systemView.viewOut("请输入要删除的学生姓名");
        String name = systemView.viewIn();
        systemView.viewOut("请输入要删除的学生ID");
        String id = systemView.viewIn();

        int flag = DBTools.delete(id,name);
        if (flag == 1) {
            systemView.viewOut("成功删除ID为:" + id + "\n姓名为:" + name + "的学生信息");
        } else {
            systemView.viewOut("新建失败,请检查数值是否正确,ID是否已经存在.");
        }
    }
}
