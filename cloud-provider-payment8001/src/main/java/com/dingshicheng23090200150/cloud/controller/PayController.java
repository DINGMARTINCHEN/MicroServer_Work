package com.dingshicheng23090200150.cloud.controller;

import com.dingshicheng23090200150.cloud.entities.Pay;
import com.dingshicheng23090200150.cloud.entities.PayDTO;
import com.dingshicheng23090200150.cloud.resp.ResultData;
import com.dingshicheng23090200150.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "支付微服务模块", description = "支付交易CRUD接口")
@RequestMapping("/pay")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/add")
    @Operation(summary = "新增支付流水", description = "传入JSON串，新增支付记录")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        int row = payService.add(pay);
        return ResultData.success("新增成功,影响行数:" + row);
    }

    @DeleteMapping("/del/{id}")
    @Operation(summary = "删除支付流水", description = "根据ID删除支付记录")
    public ResultData<String> deletePay(@PathVariable("id") Integer id) {
        int row = payService.delete(id);
        return ResultData.success("删除成功,影响行数:" + row);
    }

    @PutMapping("/update")
    @Operation(summary = "修改支付流水", description = "传入DTO，选择性修改支付记录")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay); // DTO转实体
        int row = payService.update(pay);
        return ResultData.success("修改成功,影响行数:" + row);
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "查询单条支付流水", description = "根据ID查询支付记录，ID为-4时抛异常测试")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        // 异常测试：ID为-4时抛出运行时异常
        if (id == -4) throw new RuntimeException("id不能为负数");
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping("/getAll")
    @Operation(summary = "查询所有支付流水", description = "查询t_pay表所有未删除的记录")
    public ResultData<List<Pay>> getAll() {
        List<Pay> payList = payService.getAll();
        return ResultData.success(payList);
    }
}