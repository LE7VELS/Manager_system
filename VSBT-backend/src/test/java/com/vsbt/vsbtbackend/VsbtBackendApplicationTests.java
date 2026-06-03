package com.vsbt.vsbtbackend;

import com.vsbt.vsbtbackend.mapper.EmpMapper;
import com.vsbt.vsbtbackend.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class VsbtBackendApplicationTests {

	@Test
	void contextLoads() {
	}

    @Autowired
    private EmpMapper empMapper;

    /*@Test
    public void testList(){
        List<Emp> empList = empMapper.list();
        empList.forEach(System.out::println);
    }*/

	@Test
	public void testEnv() {
		System.out.println(
				System.getenv("OSS_ACCESS_KEY_ID")
		);
	}

}
