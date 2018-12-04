package com.luying.service.impl;

import com.luying.model.UserBo;
import com.luying.service.IMongoDao;
import com.luying.utils.Page;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: lijian
 * @create: 2018-11-10
 **/
@Service
public class MongoDaoImpl implements IMongoDao<UserBo> {

    @Autowired
    private MongoTemplate template;

    @Override
    public List<UserBo> find(Query query) {
        List<UserBo> userList = template.find(query, UserBo.class);
        return userList;
    }

    @Override
    public UserBo findOne(Query query) {
        UserBo userBo = template.findOne(query, UserBo.class);
        return userBo;
    }

    @Override
    public void save(UserBo entity) {
        template.save(entity);
    }

    @Override
    public WriteResult update(Query query, Update update) {
        if (update==null) {
            return null;
        }
        WriteResult writeResult = template.updateMulti(query, update, UserBo.class);
        return writeResult;
    }

    @Override
    public List<UserBo> findAll(String collectionName) {
        return template.findAll(UserBo.class, collectionName);
    }

    @Override
    public long count(Query query) {
        long count = template.count(query, "userBo");
        return count;
    }

    @Override
    public void remove(Query query) {
        Query query1 = new Query(Criteria.where("name").is("土豆丁233"));
        WriteResult remove = template.remove(query1, "userBo");
    }

    @Override
    public Page<UserBo> findPage(Page<UserBo> page, Query query) {
        query=query==null?new Query(Criteria.where("_id").exists(true)):query;
        long count = this.count(query);
        // 总数
        page.setTotalCount((int) count);
        int currentPage = page.getCurrentPage();
        int pageSize = page.getPageSize();
        query.skip((currentPage - 1) * pageSize).limit(pageSize);
        List<UserBo> rows = this.find(query);
        page.build(rows);
        return page;

    }

}
