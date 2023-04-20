package com.l7bug.demo.event;

import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.common.engine.api.delegate.event.FlowableEventType;

import java.util.Collection;

/**
 * 实现基础事件监听器
 *
 * @author luliangyu
 * @since 2023-04-20 16:24
 */
public class TestEventImpl implements FlowableEventListener {
	@Override
	public void onEvent(FlowableEvent flowableEvent) {
		// 事件触发时调用
	}

	@Override
	public boolean isFailOnException() {
		// 抛出异常时，返回是否失败
		return false;
	}

	@Override
	public boolean isFireOnTransactionLifecycleEvent() {
		// 返回此事件侦听器是在事件发生时立即触发还是在事务生命周期事件（提交或回滚之前）上触发。
		return false;
	}

	@Override
	public String getOnTransaction() {
		// 指示当前事务的生命周期中应触发事件的时间点。
		return null;
	}

	@Override
	public Collection<? extends FlowableEventType> getTypes() {
		// 设置监听事件注册的类型
		return FlowableEventListener.super.getTypes();
	}
}
