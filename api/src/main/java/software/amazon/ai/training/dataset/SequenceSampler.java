/*
 * Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package software.amazon.ai.training.dataset;

import java.util.NoSuchElementException;

public class SequenceSampler implements Sampler {

    private int size;
    private int current;

    public SequenceSampler() {
        size = Integer.MAX_VALUE;
    }

    public SequenceSampler(int size) {
        init(size);
    }

    /** {@inheritDoc} */
    @Override
    public final void init(int size) {
        this.size = size;
    }

    /** {@inheritDoc} */
    @Override
    public boolean hasNext() {
        return current < size;
    }

    /** {@inheritDoc} */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return current++;
    }
}
