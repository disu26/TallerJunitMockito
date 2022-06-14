package co.com.sofka;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DependencyTest {

    @Mock
    private SubDependency subDependency;

    private Dependency dependency;

    @Before
    void setUpMock() {
        subDependency = mock(SubDependency.class);
        dependency = new Dependency(subDependency);
    }

    @Test
    public void testSubDependency() {
        when(subDependency.getClassName()).thenReturn("hi there");

        assertEquals("hi there", dependency.getSubdepedencyClassName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException() {
        when(dependency.getClassName()).thenThrow(IllegalArgumentException.class);

        dependency.getClassName();
    }

    @Test
    public void testAddTwo(){
        when(dependency.addTwo(1)).thenReturn(5);

        assertEquals(5, dependency.addTwo(1));
        assertEquals(0, dependency.addTwo(27));
    }
}