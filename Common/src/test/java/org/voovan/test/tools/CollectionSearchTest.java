package org.voovan.test.tools;

import org.voovan.tools.CollectionSearch;
import org.voovan.tools.json.JSON;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 类文字命名
 *
 * @author: helyho
 * DBase Framework.
 * WebSite: https://github.com/helyho/DBase
 * Licence: Apache v2 License
 */
public class CollectionSearchTest extends TestCase{
    static class test {
        public String aaa;
        public int bbb;

        public test(int bbb, String aaa){
            this.aaa = aaa;
            this.bbb = bbb;
        }
    }

    public void testOne() {
        List<test> tl = new ArrayList<test>();
        for(int i=0;i<10;i++){
            if(i%2==0) {
                tl.add(new test(i, "fff"));
            } else {
                tl.add(new test(i, "ddd"));
            }
        }

        System.out.println(JSON.toJSON(tl));
        System.out.println(JSON.toJSON(CollectionSearch.newInstance(tl).addCondition("aaa", "ddd").sort("bbb", false).search()));
        System.out.println(JSON.toJSON(CollectionSearch.newInstance(tl).addCondition("aaa", "ddd").sort("bbb", false).page(2,2).search()));

    }
}