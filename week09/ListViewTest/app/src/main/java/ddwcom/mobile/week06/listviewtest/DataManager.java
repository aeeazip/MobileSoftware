package ddwcom.mobile.week06.listviewtest;

import java.util.ArrayList;

public class DataManager {
    private ArrayList<String>  subjectList;

    public DataManager(){
        // 원본 data  준비
        subjectList = new ArrayList<String>();
        subjectList.add("모바일소프트웨어");
        subjectList.add("네트워크");
        subjectList.add("웹서비스");
        subjectList.add("운영체제");
        subjectList.add("웹프로그래밍");

    }

    public ArrayList<String> getSubjectList(){
        return subjectList;
    }

    // data 추기
    public void addData(String newSubject){
        subjectList.add(newSubject);
    }

    // data 삭제
    public void removeData(int idx){
        subjectList.remove(idx); // 위치로 삭제
    }

    public String getSubject(int pos){
        return subjectList.get(pos) + "과목입니다.";
    }
}
