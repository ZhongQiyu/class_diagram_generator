package testSuite.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * A Java class that wraps the tests.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CanvasViewerTest.class,
        ClassInfoTest.class,
        CoordinateTest.class,
        DelegationTest.class,
        DiagramTest.class,
        InheritanceTest.class,
        InstanceTest.class,
        MethodTest.class,
        NoteTest.class,
        PanelButtonTest.class,
        PanelListenerTest.class,
        ParameterTest.class,
        ReadWriteFileTest.class,
        StereotypeTest.class,
        VariableTest.class
})
public class ClassDiagramTestSuite
{
}
