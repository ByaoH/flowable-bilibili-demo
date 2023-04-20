package com.l7bug.demo.event;

import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.engine.delegate.event.BaseEntityEventListener;

/**
 * 流程引擎定义基本监听器
 * 一般来说要覆盖一下4个方法
 *
 * @author luliangyu
 * @since 2023-04-20 17:13
 */
public class TestEventExte extends BaseEntityEventListener {
	@Override
	protected void onCreate(FlowableEvent event) {
		// 在收到实体创建事件时调用。
		super.onCreate(event);
	}

	@Override
	protected void onInitialized(FlowableEvent event) {
		// 在收到实体初始化事件时调用。
		super.onInitialized(event);
	}

	@Override
	protected void onDelete(FlowableEvent event) {
		// 在收到实体删除事件时调用。
		super.onDelete(event);
	}

	@Override
	protected void onUpdate(FlowableEvent event) {
		// 在收到实体更新事件时调用。
		super.onUpdate(event);
	}

	@Override
	protected void onEntityEvent(FlowableEvent event) {
		// 收到事件时调用，该事件不是创建、更新或删除。
		super.onEntityEvent(event);
	}
}
