import java.io.File;

public class DeleteFileTest {
    public static void main(String[] args) {
        String path = "C:/Windows/Temp/ddTest";
        deleteTempFile(path);	// 대상 폴더를 지정한다
    }
    // 특정폴더 하위 내용 전체 삭제 시
    private static void deleteTempFile(String path) {
        File file = new File(path);            // 경로를 파일객체선언
        File[] files = file.listFiles();    // 해당 폴더 안의 파일

        if (files.length > 0) {    // 파일, 폴더가 1개라도 있을경우 실행

            for (File f : files) {
                //파일지우기
                if (f.isFile()) {    // 파일일경우 해당파일 삭제
                    System.out.println("isFiles :" + f.getName());
                    f.delete();
                } else { // 폴더일경우 재귀함수로 해당폴더의 경로를 전달함
                    System.out.println("isFolder :" + f.getName());
                    deleteTempFile(f.getPath());    // 재귀함수
                }
                //폴더지우기
                f.delete();    // 폴더일경우 재귀함수가 다돌고나서, 즉 폴더안의 파일이 다지워지고 나서 해당폴더를 삭제함
            }

        }
    }
}
