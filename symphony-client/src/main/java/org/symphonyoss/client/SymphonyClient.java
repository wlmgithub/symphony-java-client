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

package org.symphonyoss.client;

import org.symphonyoss.client.model.SymAuth;
import org.symphonyoss.client.services.ChatService;
import org.symphonyoss.client.services.MessageService;
import org.symphonyoss.client.services.PresenceService;
import org.symphonyoss.client.services.RoomService;
import org.symphonyoss.exceptions.InitException;
import org.symphonyoss.symphony.clients.*;
import org.symphonyoss.symphony.clients.model.SymUser;

import javax.ws.rs.client.Client;

/**
 * General interface for all Symphony client implementations
 * <p>
 * This interface provides access to all client API implementations and services.
 *
 * @author Frank Tarsillo
 */

public interface SymphonyClient {

    /**
     * Initialize client with required parameters.
     *
     * @param symAuth    Contains valid key and session tokens generated from AuthorizationClient.
     * @param email      Email address of the BOT
     * @param agentUrl   The Agent URL
     * @param serviceUrl The Service URL (in most cases it's the POD URL)
     * @throws InitException Failure of a specific service most likely due to connectivity issues
     */
    void init(SymAuth symAuth, String email, String agentUrl, String serviceUrl) throws InitException;

    /**
     * Initialize client with required parameters and custom HTTP client.
     *
     * @param httpClient Custom http client to use when connecting to Symphony API's
     * @param symAuth    Contains valid key and session tokens generated from AuthorizationClient.
     * @param email      Email address of the BOT
     * @param agentUrl   The Agent URL
     * @param serviceUrl The Service URL (in most cases it's the POD URL)
     * @throws InitException Failure of a specific service most likely due to connectivity issues
     */
    void init(Client httpClient, SymAuth symAuth, String email, String agentUrl, String serviceUrl) throws InitException;

    /**
     * Retrieve authorization object.
     *
     * @return {@link SymAuth} Authorization object containing session and key tokens.  This can return a null value.
     */
    SymAuth getSymAuth();

    /**
     * Set authorization object
     *
     * @param symAuth Authorization object containing session and key tokens.
     */
    void setSymAuth(SymAuth symAuth);

    /**
     * Provides active  Message Service
     *
     * @return {@link MessageService}
     */
    MessageService getMessageService();

    /**
     * Provides active Presence Service.  **NOTE** Presence service is currently disabled for real-time updates
     *
     * @return {@link PresenceService}
     */
    PresenceService getPresenceService();

    /**
     * Provides active Chat Service
     *
     * @return {@link ChatService}
     */
    ChatService getChatService();

    /**
     * Provides active Room Service
     *
     * @return {@link RoomService}
     */
    RoomService getRoomService();


    /**
     * Provides instance of the Presence client
     *
     * @return {@link PresenceClient}
     */
    PresenceClient getPresenceClient();

    /**
     * Provides instance of the Streams client
     *
     * @return {@link StreamsClient}
     */
    StreamsClient getStreamsClient();

    /**
     * Provides instance of the Users client
     *
     * @return {@link UsersClient}
     */
    UsersClient getUsersClient();

    /**
     * Provides instance of the Messages Client
     *
     * @return {@link MessagesClient}
     */
    MessagesClient getMessagesClient();

    /**
     * Provides instance of the DataFeed client
     *
     * @return {@link DataFeedClient}
     */
    DataFeedClient getDataFeedClient();

    /**
     * Provides instance of the Room Membership client
     *
     * @return {@link RoomMembershipClient}
     */
    RoomMembershipClient getRoomMembershipClient();

    /**
     * Provides instance of the Attachments client
     *
     * @return {@link AttachmentsClient}
     */
    AttachmentsClient getAttachmentsClient();

    /**
     * Provides instance of the Connections client
     *
     * @return {@link ConnectionsClient}
     */
    ConnectionsClient getConnectionsClient();

    /**
     * Returns the local BOT user for the instantiated client.
     *
     * @return {@link SymUser} User representing the BOT identity
     */
    SymUser getLocalUser();

    /**
     * Returns the Agent URL used during initialization
     *
     * @return The agent URL
     */
    String getAgentUrl();

    /**
     * Returns the Service URL used during initialization
     *
     * @return The Service URL
     */
    String getServiceUrl();

    /**
     * Provides instance of the Shares client.  This client supports the distribution of entity objects.
     *
     * @return {@link ShareClient}
     */
    ShareClient getShareClient();

    /**
     * If set, returns the custom http client set during initialization.
     *
     * @return {@link Client}
     */
    Client getDefaultHttpClient();

    /**
     * Set a custom Http client to use when connecting to Symphony API's
     *
     * @param defaultHttpClient Custom HTTP client
     */
    void setDefaultHttpClient(Client defaultHttpClient);

    /**
     * Terminates all underlying services and threads.
     */
    void shutdown();
}
