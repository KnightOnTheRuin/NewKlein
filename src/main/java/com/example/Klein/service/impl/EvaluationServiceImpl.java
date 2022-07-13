package com.example.Klein.service.impl;

import com.example.Klein.entity.Evaluation;
import com.example.Klein.dao.EvaluationDao;
import com.example.Klein.service.EvaluationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 游客对酒店评价(Evaluation)表服务实现类
 *
 * @author makejava
 * @since 2022-07-13 08:26:20
 */
@Service("evaluationService")
public class EvaluationServiceImpl implements EvaluationService {
    @Resource
    private EvaluationDao evaluationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param evaluationId 主键
     * @return 实例对象
     */
    @Override
    public Evaluation queryById(Long evaluationId) {
        return this.evaluationDao.queryById(evaluationId);
    }



    /**
     * 新增数据
     *
     * @param evaluation 实例对象
     * @return 实例对象
     */
    @Override
    public Evaluation insert(Evaluation evaluation) {
        this.evaluationDao.insert(evaluation);
        return evaluation;
    }

    /**
     * 修改数据
     *
     * @param evaluation 实例对象
     * @return 实例对象
     */
    @Override
    public Evaluation update(Evaluation evaluation) {
        this.evaluationDao.update(evaluation);
        return this.queryById(evaluation.getEvaluationId());
    }

    /**
     * 通过主键删除数据
     *
     * @param evaluationId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long evaluationId) {
        return this.evaluationDao.deleteById(evaluationId) > 0;
    }
}
