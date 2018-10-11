package com.sinosoft.fileserver.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail zhoujianlong@sinosoft.com.cn
 * @time  2016-11-25 15:25:25.477 
 * TFileInfo  数据查询对象
 */
public class TFileInfoExample implements Serializable{
    private static final long serialVersionUID = 1L;
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TFileInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }
        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
              
  throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }
public Criteria andFileIdIsNull() {
            addCriterion("FileId is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("FileId is not null");
      
      return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(String value) {
            addCriterion("FileId =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(String value) {
            addCriterion("FileId <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(String value) {
            addCriterion("FileId >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(String value) {
            addCriterion("FileId >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(String value) {
            addCriterion("FileId <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(String value) {
            addCriterion("FileId <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLike(String value) {
            addCriterion("FileId like", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotLike(String value) {
            addCriterion("FileId not like", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<String> values) {
            addCriterion("FileId in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<String> values) {
            addCriterion("FileId not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(String value1, String value2) {
            addCriterion("FileId between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(String value1, String value2) {
            addCriterion("FileId not between", value1, value2, "fileId");
            return (Criteria) this;
        }

public Criteria andStorageConfigIsNull() {
            addCriterion("StorageConfig is null");
            return (Criteria) this;
        }

        public Criteria andStorageConfigIsNotNull() {
            addCriterion("StorageConfig is not null");
      
      return (Criteria) this;
        }

        public Criteria andStorageConfigEqualTo(String value) {
            addCriterion("StorageConfig =", value, "storageConfig");
            return (Criteria) this;
        }

        public Criteria andStorageConfigNotEqualTo(String value) {
            addCriterion("StorageConfig <>", value, "storageConfig");
            return (Criteria) this;
        }

        public Criteria andStorageConfigGreaterThan(String value) {
            addCriterion("StorageConfig >", value, "storageConfig");
            return (Criteria) this;
        }

        public Criteria andStorageConfigGreaterThanOrEqualTo(String value) {
            addCriterion("StorageConfig >=", value, "storageConfig");
            return (Criteria) this;
        }

        public Criteria andStorageConfigLessThan(String value) {
            addCriterion("StorageConfig <", value, "storageConfig");
            return (Criteria) this;
        }

        public Criteria andStorageConfigLessThanOrEqualTo(String value) {
            addCriterion("StorageConfig <=", value, "storageConfig");
            return (Criteria) this;
        }

        public Criteria andStorageConfigLike(String value) {
            addCriterion("StorageConfig like", value, "storageConfig");
            return (Criteria) this;
        }

        public Criteria andStorageConfigNotLike(String value) {
            addCriterion("StorageConfig not like", value, "storageConfig");
            return (Criteria) this;
        }

        public Criteria andStorageConfigIn(List<String> values) {
            addCriterion("StorageConfig in", values, "storageConfig");
            return (Criteria) this;
        }

        public Criteria andStorageConfigNotIn(List<String> values) {
            addCriterion("StorageConfig not in", values, "storageConfig");
            return (Criteria) this;
        }

        public Criteria andStorageConfigBetween(String value1, String value2) {
            addCriterion("StorageConfig between", value1, value2, "storageConfig");
            return (Criteria) this;
        }

        public Criteria andStorageConfigNotBetween(String value1, String value2) {
            addCriterion("StorageConfig not between", value1, value2, "storageConfig");
            return (Criteria) this;
        }

public Criteria andFileNameIsNull() {
            addCriterion("FileName is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("FileName is not null");
      
      return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("FileName =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("FileName <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("FileName >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("FileName >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("FileName <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("FileName <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("FileName like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("FileName not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("FileName in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("FileName not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("FileName between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("FileName not between", value1, value2, "fileName");
            return (Criteria) this;
        }

public Criteria andFileExtIsNull() {
            addCriterion("FileExt is null");
            return (Criteria) this;
        }

        public Criteria andFileExtIsNotNull() {
            addCriterion("FileExt is not null");
      
      return (Criteria) this;
        }

        public Criteria andFileExtEqualTo(String value) {
            addCriterion("FileExt =", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtNotEqualTo(String value) {
            addCriterion("FileExt <>", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtGreaterThan(String value) {
            addCriterion("FileExt >", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtGreaterThanOrEqualTo(String value) {
            addCriterion("FileExt >=", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtLessThan(String value) {
            addCriterion("FileExt <", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtLessThanOrEqualTo(String value) {
            addCriterion("FileExt <=", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtLike(String value) {
            addCriterion("FileExt like", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtNotLike(String value) {
            addCriterion("FileExt not like", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtIn(List<String> values) {
            addCriterion("FileExt in", values, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtNotIn(List<String> values) {
            addCriterion("FileExt not in", values, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtBetween(String value1, String value2) {
            addCriterion("FileExt between", value1, value2, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtNotBetween(String value1, String value2) {
            addCriterion("FileExt not between", value1, value2, "fileExt");
            return (Criteria) this;
        }

public Criteria andFilePathIsNull() {
            addCriterion("FilePath is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("FilePath is not null");
      
      return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("FilePath =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("FilePath <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("FilePath >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("FilePath >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("FilePath <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("FilePath <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("FilePath like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("FilePath not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("FilePath in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("FilePath not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("FilePath between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("FilePath not between", value1, value2, "filePath");
            return (Criteria) this;
        }

public Criteria andFileSizeIsNull() {
            addCriterion("FileSize is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("FileSize is not null");
      
      return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(String value) {
            addCriterion("FileSize =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(String value) {
            addCriterion("FileSize <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(String value) {
            addCriterion("FileSize >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(String value) {
            addCriterion("FileSize >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(String value) {
            addCriterion("FileSize <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(String value) {
            addCriterion("FileSize <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLike(String value) {
            addCriterion("FileSize like", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotLike(String value) {
            addCriterion("FileSize not like", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<String> values) {
            addCriterion("FileSize in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<String> values) {
            addCriterion("FileSize not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(String value1, String value2) {
            addCriterion("FileSize between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(String value1, String value2) {
            addCriterion("FileSize not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

public Criteria andCreateByIsNull() {
            addCriterion("CreateBy is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("CreateBy is not null");
      
      return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("CreateBy =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("CreateBy <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("CreateBy >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("CreateBy >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("CreateBy <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("CreateBy <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("CreateBy like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("CreateBy not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("CreateBy in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("CreateBy not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("CreateBy between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("CreateBy not between", value1, value2, "createBy");
            return (Criteria) this;
        }

public Criteria andCreateTimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("CreateTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CreateTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CreateTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CreateTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("CreateTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CreateTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("CreateTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CreateTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CreateTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CreateTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

public Criteria andUpdateTimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("UpdateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UpdateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UpdateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UpdateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("UpdateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UpdateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("UpdateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UpdateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UpdateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UpdateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

public Criteria andUpdateByIsNull() {
            addCriterion("UpdateBy is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("UpdateBy is not null");
      
      return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("UpdateBy =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("UpdateBy <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("UpdateBy >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("UpdateBy >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("UpdateBy <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("UpdateBy <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("UpdateBy like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("UpdateBy not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("UpdateBy in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("UpdateBy not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("UpdateBy between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("UpdateBy not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

public Criteria andIsDeletedIsNull() {
            addCriterion("IsDeleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("IsDeleted is not null");
      
      return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(String value) {
            addCriterion("IsDeleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(String value) {
            addCriterion("IsDeleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(String value) {
            addCriterion("IsDeleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("IsDeleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(String value) {
            addCriterion("IsDeleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(String value) {
            addCriterion("IsDeleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLike(String value) {
            addCriterion("IsDeleted like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotLike(String value) {
            addCriterion("IsDeleted not like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<String> values) {
            addCriterion("IsDeleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<String> values) {
            addCriterion("IsDeleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(String value1, String value2) {
            addCriterion("IsDeleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(String value1, String value2) {
            addCriterion("IsDeleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

public Criteria andBussTypeIsNull() {
            addCriterion("BussType is null");
            return (Criteria) this;
        }

        public Criteria andBussTypeIsNotNull() {
            addCriterion("BussType is not null");
      
      return (Criteria) this;
        }

        public Criteria andBussTypeEqualTo(String value) {
            addCriterion("BussType =", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotEqualTo(String value) {
            addCriterion("BussType <>", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeGreaterThan(String value) {
            addCriterion("BussType >", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BussType >=", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeLessThan(String value) {
            addCriterion("BussType <", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeLessThanOrEqualTo(String value) {
            addCriterion("BussType <=", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeLike(String value) {
            addCriterion("BussType like", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotLike(String value) {
            addCriterion("BussType not like", value, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeIn(List<String> values) {
            addCriterion("BussType in", values, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotIn(List<String> values) {
            addCriterion("BussType not in", values, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeBetween(String value1, String value2) {
            addCriterion("BussType between", value1, value2, "bussType");
            return (Criteria) this;
        }

        public Criteria andBussTypeNotBetween(String value1, String value2) {
            addCriterion("BussType not between", value1, value2, "bussType");
            return (Criteria) this;
        }

public Criteria andStorageMediumIsNull() {
            addCriterion("StorageMedium is null");
            return (Criteria) this;
        }

        public Criteria andStorageMediumIsNotNull() {
            addCriterion("StorageMedium is not null");
      
      return (Criteria) this;
        }

        public Criteria andStorageMediumEqualTo(String value) {
            addCriterion("StorageMedium =", value, "storageMedium");
            return (Criteria) this;
        }

        public Criteria andStorageMediumNotEqualTo(String value) {
            addCriterion("StorageMedium <>", value, "storageMedium");
            return (Criteria) this;
        }

        public Criteria andStorageMediumGreaterThan(String value) {
            addCriterion("StorageMedium >", value, "storageMedium");
            return (Criteria) this;
        }

        public Criteria andStorageMediumGreaterThanOrEqualTo(String value) {
            addCriterion("StorageMedium >=", value, "storageMedium");
            return (Criteria) this;
        }

        public Criteria andStorageMediumLessThan(String value) {
            addCriterion("StorageMedium <", value, "storageMedium");
            return (Criteria) this;
        }

        public Criteria andStorageMediumLessThanOrEqualTo(String value) {
            addCriterion("StorageMedium <=", value, "storageMedium");
            return (Criteria) this;
        }

        public Criteria andStorageMediumLike(String value) {
            addCriterion("StorageMedium like", value, "storageMedium");
            return (Criteria) this;
        }

        public Criteria andStorageMediumNotLike(String value) {
            addCriterion("StorageMedium not like", value, "storageMedium");
            return (Criteria) this;
        }

        public Criteria andStorageMediumIn(List<String> values) {
            addCriterion("StorageMedium in", values, "storageMedium");
            return (Criteria) this;
        }

        public Criteria andStorageMediumNotIn(List<String> values) {
            addCriterion("StorageMedium not in", values, "storageMedium");
            return (Criteria) this;
        }

        public Criteria andStorageMediumBetween(String value1, String value2) {
            addCriterion("StorageMedium between", value1, value2, "storageMedium");
            return (Criteria) this;
        }

        public Criteria andStorageMediumNotBetween(String value1, String value2) {
            addCriterion("StorageMedium not between", value1, value2, "storageMedium");
            return (Criteria) this;
        }

public Criteria andSystemIdIsNull() {
            addCriterion("SystemId is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("SystemId is not null");
      
      return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(String value) {
            addCriterion("SystemId =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(String value) {
            addCriterion("SystemId <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(String value) {
            addCriterion("SystemId >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("SystemId >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(String value) {
            addCriterion("SystemId <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(String value) {
            addCriterion("SystemId <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLike(String value) {
            addCriterion("SystemId like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotLike(String value) {
            addCriterion("SystemId not like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(List<String> values) {
            addCriterion("SystemId in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<String> values) {
            addCriterion("SystemId not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(String value1, String value2) {
            addCriterion("SystemId between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(String value1, String value2) {
            addCriterion("SystemId not between", value1, value2, "systemId");
            return (Criteria) this;
        }

public Criteria andFileMD5IsNull() {
            addCriterion("FileMD5 is null");
            return (Criteria) this;
        }

        public Criteria andFileMD5IsNotNull() {
            addCriterion("FileMD5 is not null");
      
      return (Criteria) this;
        }

        public Criteria andFileMD5EqualTo(String value) {
            addCriterion("FileMD5 =", value, "fileMD5");
            return (Criteria) this;
        }

        public Criteria andFileMD5NotEqualTo(String value) {
            addCriterion("FileMD5 <>", value, "fileMD5");
            return (Criteria) this;
        }

        public Criteria andFileMD5GreaterThan(String value) {
            addCriterion("FileMD5 >", value, "fileMD5");
            return (Criteria) this;
        }

        public Criteria andFileMD5GreaterThanOrEqualTo(String value) {
            addCriterion("FileMD5 >=", value, "fileMD5");
            return (Criteria) this;
        }

        public Criteria andFileMD5LessThan(String value) {
            addCriterion("FileMD5 <", value, "fileMD5");
            return (Criteria) this;
        }

        public Criteria andFileMD5LessThanOrEqualTo(String value) {
            addCriterion("FileMD5 <=", value, "fileMD5");
            return (Criteria) this;
        }

        public Criteria andFileMD5Like(String value) {
            addCriterion("FileMD5 like", value, "fileMD5");
            return (Criteria) this;
        }

        public Criteria andFileMD5NotLike(String value) {
            addCriterion("FileMD5 not like", value, "fileMD5");
            return (Criteria) this;
        }

        public Criteria andFileMD5In(List<String> values) {
            addCriterion("FileMD5 in", values, "fileMD5");
            return (Criteria) this;
        }

        public Criteria andFileMD5NotIn(List<String> values) {
            addCriterion("FileMD5 not in", values, "fileMD5");
            return (Criteria) this;
        }

        public Criteria andFileMD5Between(String value1, String value2) {
            addCriterion("FileMD5 between", value1, value2, "fileMD5");
            return (Criteria) this;
        }

        public Criteria andFileMD5NotBetween(String value1, String value2) {
            addCriterion("FileMD5 not between", value1, value2, "fileMD5");
            return (Criteria) this;
        }


    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

  
      public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}