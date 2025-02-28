package com.redfish.cc;

import com.redfish.common.util.lock.RedisDistributedLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zly
 * @date 2025/2/28
 * @description TODO
 * @Copyright: 儒松科技
 */
@RestController("TempController")
public class TempController {

    @Resource
    private RedisDistributedLock lockService;



    @GetMapping("/lock")
    public String performTaskWithLock() throws InterruptedException {
        String lockKey = "myLock";
        String requestId = "requestId"; // 实际应用中应使用UUID.randomUUID().toString()
        long expireTime = 10; // 锁的有效期为10秒

        boolean isLocked = lockService.tryLock(lockKey, requestId, expireTime);
        if (isLocked) {
            try {
                System.out.println("Lock acquired and performing task...");
                // 在这里执行需要加锁保护的任务
                Thread.sleep(5000); // 模拟任务执行，假设任务需要5秒完成
            } finally {
                boolean isUnlocked = lockService.unlock(lockKey, requestId);
                if (isUnlocked) {
                    System.out.println("Lock released successfully.");
                } else {
                    System.out.println("Failed to release lock.");
                }
            }
        } else {
            System.out.println("Failed to acquire lock.");
        }

        return "Task completed.";
    }

}
