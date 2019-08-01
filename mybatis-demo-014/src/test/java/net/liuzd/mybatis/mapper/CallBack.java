package net.liuzd.mybatis.mapper;

import org.apache.ibatis.session.SqlSession;

/**
 * @copyright 2011-2017 jd.com
 * @author <a href="mailto:liuzidong@jd.com">liuzidong</a>
 * @version V1.0 下午4:22:34
 */
public interface CallBack {

    void execute(SqlSession session);

}
