/*
 * Copyright 2010 The Apache Software Foundation
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.phoenix.expression.aggregator;

import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.util.Bytes;

import org.apache.phoenix.schema.ColumnModifier;


/**
 * Aggregator that finds the max of values. Inverse of {@link MinAggregator}.
 *
 * @author syyang
 * @since 0.1
 */
abstract public class MaxAggregator extends MinAggregator {
    
    public MaxAggregator(ColumnModifier columnModifier) {
        super(columnModifier);
    }
    
    @Override
    protected boolean keepFirst(ImmutableBytesWritable ibw1, ImmutableBytesWritable ibw2) {
        return !super.keepFirst(ibw1, ibw2);
    }
    
    @Override
    public String toString() {
        return "MAX [value=" + Bytes.toStringBinary(value.get(),value.getOffset(),value.getLength()) + "]";
    }

}
