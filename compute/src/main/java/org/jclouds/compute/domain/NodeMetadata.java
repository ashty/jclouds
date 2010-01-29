/**
 *
 * Copyright (C) 2009 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */
package org.jclouds.compute.domain;

import java.net.InetAddress;
import java.util.Map;
import java.util.Set;

import org.jclouds.domain.Credentials;

/**
 * @author Adrian Cole
 * @author Ivan Meredith
 */
public interface NodeMetadata extends ComputeMetadata {

   /**
    * Tag used for all resources that belong to the same logical group. run, destroy commands are
    * scoped to tag.
    * 
    * @return tag for this node, or null, if not a part of a group
    * 
    */
   String getTag();

   /**
    * Current State of the node
    */
   NodeState getState();

   /**
    * All public IP addresses, potentially including shared ips.
    */
   Set<InetAddress> getPublicAddresses();

   /**
    * All private IP addresses.
    */
   Set<InetAddress> getPrivateAddresses();

   /**
    * If possible, these are returned upon all detail requests. However, it is often the case that
    * credentials are only available at "run" time.
    */
   Credentials getCredentials();

   /**
    * Other variables present that the provider supports
    */
   Map<String, String> getExtra();
}