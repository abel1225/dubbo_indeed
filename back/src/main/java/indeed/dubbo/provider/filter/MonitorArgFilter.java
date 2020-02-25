package indeed.dubbo.provider.filter;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.json.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Activate
@Slf4j
public class MonitorArgFilter implements Filter {

	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		try {
			log.info("path:" + invocation.getAttachments().get("path"));
			log.info("method:" + invocation.getMethodName());
			log.info("arg:" + Arrays.toString(invocation.getArguments()));
			long stTime = System.currentTimeMillis();
			Result result = invoker.invoke(invocation);
			log.info("result:" + JSON.json(result.getValue()));
			log.info("consume timeMillis:" + (System.currentTimeMillis() - stTime));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
