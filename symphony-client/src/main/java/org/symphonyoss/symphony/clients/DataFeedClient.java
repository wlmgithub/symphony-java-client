/*
 *
 * Copyright 2016 The Symphony Software Foundation
 *
 * Licensed to The Symphony Software Foundation (SSF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.symphonyoss.symphony.clients;

import org.symphonyoss.exceptions.DataFeedException;
import org.symphonyoss.symphony.agent.model.Datafeed;
import org.symphonyoss.symphony.agent.model.V2BaseMessage;


import java.util.List;

/**
 * Provides access to datafeed in order to stream all message events (messages) through blocking calls.
 *
 * Created by Frank Tarsillo on 5/15/2016.
 */
public interface DataFeedClient {
    /**
     * Create a datafeed to consume messages from
     * @return Datafeed object to process messages from
     * @throws DataFeedException Caused by Symphony API calls
     */
    Datafeed createDatafeed() throws DataFeedException;

    /**
     * This will return messages from datafeed object through underlying blocking calls.  This method should be called
     * repeatedly to pull message data.
     * @param datafeed Datafeed object associated with BOT user
     * @return List of base messages
     * @throws DataFeedException Caused by Symphony API calls
     */
    List<V2BaseMessage> getMessagesFromDatafeed(Datafeed datafeed) throws DataFeedException;

    }
