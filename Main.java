class Main{
  public static void main(String[] args){
    Request req = new Request();
    req.req("https://www.muryou-tools.com/test/posttestutf8.php", Request.METHOD_POST, "name=shiroha");
  }
}