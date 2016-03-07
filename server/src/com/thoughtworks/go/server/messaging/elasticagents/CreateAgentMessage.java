/*
 * Copyright 2016 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.thoughtworks.go.server.messaging.elasticagents;

import com.thoughtworks.go.config.JobAgentConfig;
import com.thoughtworks.go.server.messaging.GoMessage;

import java.util.Map;

public class CreateAgentMessage implements GoMessage {
    private final String autoregisterKey;
    private final String environment;
    private final Map<String, String> configuration;
    private final String pluginId;

    public CreateAgentMessage(String autoregisterKey, String environment, JobAgentConfig jobAgentConfig) {
        this.autoregisterKey = autoregisterKey;
        this.environment = environment;
        this.pluginId = jobAgentConfig.getPluginId();
        this.configuration = jobAgentConfig.getConfigurationAsMap(true);
    }

    public String autoregisterKey() {
        return autoregisterKey;
    }

    public String environment() {
        return environment;
    }

    @Override
    public String toString() {
        return "CreateAgentMessage{" +
                "autoregisterKey='" + autoregisterKey + '\'' +
                ", environment='" + environment + '\'' +
                ", jobAgentConfig=" + configuration +
                '}';
    }

    public String getPluginId() {
        return pluginId;
    }

    public Map<String, String> configuration() {
        return configuration;
    }
}
