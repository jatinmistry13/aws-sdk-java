/*
 * Copyright 2012-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.ecs.model.transform;

import java.io.ByteArrayInputStream;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.ecs.model.*;
import com.amazonaws.transform.Marshaller;

import com.amazonaws.protocol.json.*;

/**
 * CreateServiceRequest Marshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class CreateServiceRequestMarshaller implements Marshaller<Request<CreateServiceRequest>, CreateServiceRequest> {

    private final SdkJsonMarshallerFactory protocolFactory;

    public CreateServiceRequestMarshaller(SdkJsonMarshallerFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<CreateServiceRequest> marshall(CreateServiceRequest createServiceRequest) {

        if (createServiceRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        Request<CreateServiceRequest> request = new DefaultRequest<CreateServiceRequest>(createServiceRequest, "AmazonECS");
        request.addHeader("X-Amz-Target", "AmazonEC2ContainerServiceV20141113.CreateService");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            final StructuredJsonGenerator jsonGenerator = protocolFactory.createGenerator();

            jsonGenerator.writeStartObject();

            if (createServiceRequest.getCluster() != null) {
                jsonGenerator.writeFieldName("cluster").writeValue(createServiceRequest.getCluster());
            }
            if (createServiceRequest.getServiceName() != null) {
                jsonGenerator.writeFieldName("serviceName").writeValue(createServiceRequest.getServiceName());
            }
            if (createServiceRequest.getTaskDefinition() != null) {
                jsonGenerator.writeFieldName("taskDefinition").writeValue(createServiceRequest.getTaskDefinition());
            }

            com.amazonaws.internal.SdkInternalList<LoadBalancer> loadBalancersList = (com.amazonaws.internal.SdkInternalList<LoadBalancer>) createServiceRequest
                    .getLoadBalancers();
            if (!loadBalancersList.isEmpty() || !loadBalancersList.isAutoConstruct()) {
                jsonGenerator.writeFieldName("loadBalancers");
                jsonGenerator.writeStartArray();
                for (LoadBalancer loadBalancersListValue : loadBalancersList) {
                    if (loadBalancersListValue != null) {

                        LoadBalancerJsonMarshaller.getInstance().marshall(loadBalancersListValue, jsonGenerator);
                    }
                }
                jsonGenerator.writeEndArray();
            }
            if (createServiceRequest.getDesiredCount() != null) {
                jsonGenerator.writeFieldName("desiredCount").writeValue(createServiceRequest.getDesiredCount());
            }
            if (createServiceRequest.getClientToken() != null) {
                jsonGenerator.writeFieldName("clientToken").writeValue(createServiceRequest.getClientToken());
            }
            if (createServiceRequest.getRole() != null) {
                jsonGenerator.writeFieldName("role").writeValue(createServiceRequest.getRole());
            }
            if (createServiceRequest.getDeploymentConfiguration() != null) {
                jsonGenerator.writeFieldName("deploymentConfiguration");
                DeploymentConfigurationJsonMarshaller.getInstance().marshall(createServiceRequest.getDeploymentConfiguration(), jsonGenerator);
            }

            com.amazonaws.internal.SdkInternalList<PlacementConstraint> placementConstraintsList = (com.amazonaws.internal.SdkInternalList<PlacementConstraint>) createServiceRequest
                    .getPlacementConstraints();
            if (!placementConstraintsList.isEmpty() || !placementConstraintsList.isAutoConstruct()) {
                jsonGenerator.writeFieldName("placementConstraints");
                jsonGenerator.writeStartArray();
                for (PlacementConstraint placementConstraintsListValue : placementConstraintsList) {
                    if (placementConstraintsListValue != null) {

                        PlacementConstraintJsonMarshaller.getInstance().marshall(placementConstraintsListValue, jsonGenerator);
                    }
                }
                jsonGenerator.writeEndArray();
            }

            com.amazonaws.internal.SdkInternalList<PlacementStrategy> placementStrategyList = (com.amazonaws.internal.SdkInternalList<PlacementStrategy>) createServiceRequest
                    .getPlacementStrategy();
            if (!placementStrategyList.isEmpty() || !placementStrategyList.isAutoConstruct()) {
                jsonGenerator.writeFieldName("placementStrategy");
                jsonGenerator.writeStartArray();
                for (PlacementStrategy placementStrategyListValue : placementStrategyList) {
                    if (placementStrategyListValue != null) {

                        PlacementStrategyJsonMarshaller.getInstance().marshall(placementStrategyListValue, jsonGenerator);
                    }
                }
                jsonGenerator.writeEndArray();
            }

            jsonGenerator.writeEndObject();

            byte[] content = jsonGenerator.getBytes();
            request.setContent(new ByteArrayInputStream(content));
            request.addHeader("Content-Length", Integer.toString(content.length));
            request.addHeader("Content-Type", protocolFactory.getContentType());
        } catch (Throwable t) {
            throw new SdkClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }

}
