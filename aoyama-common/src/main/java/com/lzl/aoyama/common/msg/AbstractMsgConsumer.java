import com.lzl.aoyama.common.msg.MsgContent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lzl
 * @ClassName AbstractMsgConsumer
 * @date: 2021/8/23 上午11:09
 * @Description:
 */
@Slf4j
public abstract class AbstractMsgConsumer {


    public void consumer(MsgContent msgContent) {
        Object result;
        try {
            result = send(msgContent);
        } catch (Exception e) {
            log.error(e.getMessage());
        }finally {
            log.info(msgContent.getContent());
        }

    }

    public abstract Object send(MsgContent msgContent);
}
