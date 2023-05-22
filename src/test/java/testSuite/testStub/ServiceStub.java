package testSuite.testStub;

/**
 * A Java class that attempts to implement the test stub
 * design pattern for the Service class.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
class ServiceStub implements ServiceDouble {
    public String doSomething(){
        return "my stubbed return";
    }
}

//class ServiceStub extends Service {
//    @Override
//    public String doSomething(){
//        return "stubbed result";
//    }
//}
