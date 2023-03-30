/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.eventmesh.storage.knative.consumer;

import org.apache.eventmesh.api.factory.StoragePluginFactory;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

public class KnativeConsumerImplTest {

    @Test
    public void testSubscribe() throws Exception {
        Properties properties = new Properties();
        final String topic = "messages";
        properties.put("topic", topic);

        // Create a Knative consumer:
        KnativeConsumerImpl knativeConsumer =
                (KnativeConsumerImpl) StoragePluginFactory.getMeshMQPushConsumer("knative");

        try {
            knativeConsumer.init(properties);

            // Subscribe:
            knativeConsumer.subscribe(properties.getProperty("topic"));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}