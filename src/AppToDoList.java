
public class AppToDoList {
        public static  String[] model = new String[10];

        public static java.util.Scanner scanner = new java.util.Scanner(System.in);

        public static void main(String[] args) {
            viewShowToDoList();
        }

        /**
         * Menampilkasn Data
         */
        public static void showToDoList(){
            System.out.println("TODO List");
            for (var i = 0; i < model.length; i++){
                var todo = model[i];
                var no = i + 1;

                if (todo != null){
                    System.out.println(no + ". " + todo);
                }
            }
        }
        public static void testShowToDoList(){
            model[0] = "Belajar Java Dasar";
            model[1] = "Membuat Aplikasi To Do List Sedrhana";
            model[2] = "Belajar Database MySql";
            showToDoList();
        }
        /**
         * Menambah Data
         */
        public static void addToDoList(String todo){
            // cek apakah model penuh?
            var isFull = true;
            for (int i = 0; i < model.length; i++){
                if (model[i] == null){
                    //model masih ada yang kosong
                    isFull = false;
                    break;
                }
            }

            //jika model penuh maka resize array 2x lipat
            if (isFull){
                var temp = model;
                model = new String[model.length * 2];

                for (var i = 0; i < temp.length; i++){
                    model[i] = temp[i];
                }
            }


            //tambahkan ke posisi yang data array nya NULL
            for (var i = 0; i < model.length; i++){
                if (model[i] == null){
                    model[i] = todo;
                    break;
                }
            }
        }
        public static void testAddToDoList(){
            for (var i = 1; i < 26; i++){
                addToDoList("Contoh To Do -> "+ i );
            }
            showToDoList();
        }

        /**
         * Menghapus Data
         */
        public static boolean removeToDoList(Integer number){
            if ((number -1 ) >= model.length){
                return  false;
            } else if (model[number - 1] == null) {
                return false;
            }else {
                for (int i = (number - 1); i < model.length; i++){
                    if(i == (model.length - 1)){
                        model[i] = null;
                    }else {
                        model[i] = model[i + 1];
                    }
                }
                return true;
            }
        }

        public static void testRemoveToDoList(){
            addToDoList("Satu");
            addToDoList("Dua");
            addToDoList("Tiga");
            addToDoList("Empat");
            addToDoList("Lima");
            addToDoList("Enam");

            var result = removeToDoList(20);
            System.out.println(result);

            var result2 = removeToDoList(8);
            System.out.println(result2);

           var result3 =removeToDoList(2);
            System.out.println(result3);

            showToDoList();
        }

        public static String input(String info){
            System.out.print(info + " : ");
            String data = scanner.nextLine();
            return data;
        }

        public static void testInput(){
            var name = input("Nama");
            System.out.println("Hi, "+name);

            var channel = input("Channel");
            System.out.println(channel);
        }

        /**
         * Menampilkasn Data To Do List
         */
        public static void viewShowToDoList(){

            while (true){
                showToDoList();

                System.out.println("Menu To Do List");
                System.out.println("1. Tambah");
                System.out.println("2. Hapus");
                System.out.println("x. Keluar");

                var input = input("Pilih");

                if (input.equals("1")){
                    viewAddToDoList();
                }else if (input.equals("2")){
                    viewRemoveToDoList();
                }else if(input.equals("x")){
                    break;
                }else {
                    System.out.println("Pilihan tidak sesuai");
                }
            }
        }

        public static void testViewShowToDoList(){
            addToDoList("Satu");
            addToDoList("Dua");
            addToDoList("Tiga");
            addToDoList("Empat");
            addToDoList("Lima");
            viewShowToDoList();
        }

        /**
         * View Tambah To Do List
         */
        public static void viewAddToDoList(){
            System.out.println("Menambah TODOLIST");

            var todo = input("Todo (x Jika Batal)");

            if (todo.equals("x")){
//                batal
            }else {
                addToDoList(todo);
            }
        }

        public static void testViewTodoList(){
            addToDoList("Satu");
            addToDoList("Dua");

            viewShowToDoList();

            showToDoList();
        }
        /**
         * View Delete To Do List
         */
        public static void viewRemoveToDoList(){
            System.out.println("Menghapus TO DO List");

            var number = input("Nomor yang dihapus (x jika batal)");

            if (number.equals("x")){
                //batal
            }else {
                boolean success = removeToDoList(Integer.valueOf(number));
                if (!success){
                    System.out.println("Gagal menghapus TODO List");
                }
            }
        }

        public static void testViewRemoveToDoList(){
            addToDoList("Satu");
            addToDoList("Dua");
            addToDoList("Tiga");

            showToDoList();

            viewRemoveToDoList();

            showToDoList();
        }
}
