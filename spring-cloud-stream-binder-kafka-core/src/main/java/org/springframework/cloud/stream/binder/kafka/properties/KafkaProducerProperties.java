/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.stream.binder.kafka.properties;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

/**
 * @author Marius Bogoevici
 */
public class KafkaProducerProperties {

	/**
	 * bufferSize property is deprecated.
	 * It is recommended to set compressionType as one of the per binding Kafka producer `configuration` properties.
	 * If using KafkaAutoConfiguration from Spring Boot 1.5.x, `spring.kafka.producer.batchSize` property can also be used.
	 */
	@Deprecated
	private int bufferSize = 16384;

	/**
	 * compressionType property is deprecated.
	 * It is recommended to set compressionType as one of the per binding Kafka producer `configuration` properties.
	 * If using KafkaAutoConfiguration from Spring Boot 1.5.x, `spring.kafka.producer.compressionType` property can also be used.
	 */
	@Deprecated
	private CompressionType compressionType = CompressionType.none;

	private boolean sync;

	private int batchTimeout;

	private Map<String, String> configuration = new HashMap<>();

	public int getBufferSize() {
		return this.bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}

	@NotNull
	public CompressionType getCompressionType() {
		return this.compressionType;
	}

	public void setCompressionType(CompressionType compressionType) {
		this.compressionType = compressionType;
	}

	public boolean isSync() {
		return this.sync;
	}

	public void setSync(boolean sync) {
		this.sync = sync;
	}

	public int getBatchTimeout() {
		return this.batchTimeout;
	}

	public void setBatchTimeout(int batchTimeout) {
		this.batchTimeout = batchTimeout;
	}

	public Map<String, String> getConfiguration() {
		return this.configuration;
	}

	public void setConfiguration(Map<String, String> configuration) {
		this.configuration = configuration;
	}

	@Deprecated
	/**
	 * @see compressionType
	 */
	public enum CompressionType {
		none,
		gzip,
		snappy,
		lz4
	}
}
