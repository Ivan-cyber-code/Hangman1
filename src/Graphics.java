 class Graphics {
     static void showHangman(int count_error) {
        switch (count_error) {

            case 6:
                System.out.println("""               
                             |---------
                             |        |
                             0        |
                            /|\\       |
                            / \\       |
                        ______________|
                        """);
                break;

            case 1:
                System.out.println("""               
                             |---------
                             |        |
                             0        |
                                      |
                                      |
                        ______________|
                        """);
                break;

            case 2:
                System.out.println("""               
                             |---------
                             |        |
                             0        |
                            /         |
                                      |
                        ______________|
                        """);
                break;

            case 3:
                System.out.println("""               
                             |---------
                             |        |
                             0        |
                            /|        |
                                      |
                        ______________|
                        """);
                break;

            case 4:
                System.out.println("""               
                             |---------
                             |        |
                             0        |
                            /|\\       |
                                      |
                        ______________|
                        """);
                break;

            case 5:
                System.out.println("""               
                             |---------
                             |        |
                             0        |
                            /|\\       |
                            /         |
                        ______________|
                        """);
                break;
        }
    }
}
