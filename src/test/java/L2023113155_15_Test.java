import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 测试用例设计原则：
 * 1. 等价类划分：将输入划分为有效版本号格式和无效版本号格式
 * 2. 边界值分析：测试空字符串、单版本号、多级版本号等边界情况
 * 3. 特殊字符测试：测试包含非数字字符的情况
 * 4. 正常功能测试：测试大小比较的各种情况
 */

public class L2023113155_15_Test {
    
    /**
     * 测试目的：验证正常版本号比较功能
     * 测试用例：标准版本号比较，包含前导零的情况
     */
    @Test
    public void testNormalVersionComparison() {
        Solution15 solution = new Solution15();
        
        // 相等情况测试
        assertEquals(0, solution.compareVersion("1.01", "1.001"));
        assertEquals(0, solution.compareVersion("1.0", "1.0.0"));
        assertEquals(0, solution.compareVersion("2.5.0", "2.5"));
        
        // version1 > version2 情况
        assertEquals(1, solution.compareVersion("1.2", "1.1"));
        assertEquals(1, solution.compareVersion("2.0", "1.9.9"));
        assertEquals(1, solution.compareVersion("1.10", "1.9"));
        
        // version1 < version2 情况
        assertEquals(-1, solution.compareVersion("0.1", "1.1"));
        assertEquals(-1, solution.compareVersion("1.0", "1.0.1"));
        assertEquals(-1, solution.compareVersion("1.8", "1.10"));
    }
    
    /**
     * 测试目的：验证边界条件处理
     * 测试用例：空字符串、null值、单版本号等边界情况
     */
    @Test
    public void testBoundaryConditions() {
        Solution15 solution = new Solution15();
        
        // 空字符串和null值测试
        assertEquals(0, solution.compareVersion("", ""));
        assertEquals(-1, solution.compareVersion("", "1.0"));
        assertEquals(1, solution.compareVersion("1.0", ""));
        assertEquals(0, solution.compareVersion(null, null));
        assertEquals(-1, solution.compareVersion(null, "1.0"));
        assertEquals(1, solution.compareVersion("1.0", null));
        
        // 单版本号测试
        assertEquals(0, solution.compareVersion("1", "1"));
        assertEquals(1, solution.compareVersion("2", "1"));
        assertEquals(-1, solution.compareVersion("1", "2"));
    }
    
    /**
     * 测试目的：验证异常输入处理
     * 测试用例：包含非数字字符的版本号
     */
    @Test
    public void testInvalidInputHandling() {
        Solution15 solution = new Solution15();
        
        // 包含非数字字符的情况
        assertEquals(0, solution.compareVersion("1.a", "1.b"));
        assertEquals(1, solution.compareVersion("2.x", "1.y"));
        assertEquals(-1, solution.compareVersion("1.0-beta", "2.0-alpha"));
        
        // 混合数字和非数字
        assertEquals(0, solution.compareVersion("1.0", "1.0rc"));
        assertEquals(1, solution.compareVersion("1.1", "1.0a"));
    }
    
    /**
     * 测试目的：验证长版本号比较
     * 测试用例：多级版本号比较
     */
    @Test
    public void testLongVersionComparison() {
        Solution15 solution = new Solution15();
        
        // 长版本号测试
        assertEquals(0, solution.compareVersion("1.2.3.4.5", "1.2.3.4.5"));
        assertEquals(1, solution.compareVersion("1.2.3.4.6", "1.2.3.4.5"));
        assertEquals(-1, solution.compareVersion("1.2.3.4.4", "1.2.3.4.5"));
        assertEquals(1, solution.compareVersion("1.2.3.5", "1.2.3.4.9"));
    }
    
    /**
     * 测试目的：验证前导零和多位数字处理
     * 测试用例：测试版本号中前导零和多位数的情况
     */
    @Test
    public void testLeadingZerosAndMultiDigit() {
        Solution15 solution = new Solution15();
        
        // 前导零处理
        assertEquals(0, solution.compareVersion("01.02", "1.2"));
        assertEquals(0, solution.compareVersion("001.002", "1.2"));
        
        // 多位数版本号
        assertEquals(1, solution.compareVersion("1.10", "1.9"));
        assertEquals(-1, solution.compareVersion("1.9", "1.10"));
        assertEquals(0, solution.compareVersion("1.100", "1.100"));
    }
}