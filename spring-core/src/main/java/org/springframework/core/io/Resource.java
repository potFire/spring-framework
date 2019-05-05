/*
 * Copyright 2002-2018 the original author or authors.
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

package org.springframework.core.io;

import org.springframework.lang.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Spring 框架所有资源的抽象和访问接口
 *
 * Interface for a resource descriptor that abstracts from the actual
 * type of underlying resource, such as a file or class path resource.
 *
 * <p>An InputStream can be opened for every resource if it exists in
 * physical form, but a URL or File handle can just be returned for
 * certain resources. The actual behavior is implementation-specific.
 *
 * @author Juergen Hoeller
 * @since 28.12.2003
 * @see #getInputStream()
 * @see #getURL()
 * @see #getURI()
 * @see #getFile()
 * @see WritableResource
 * @see ContextResource
 * @see UrlResource
 * @see ClassPathResource
 * @see FileSystemResource
 * @see PathResource
 * @see ByteArrayResource
 * @see InputStreamResource
 */
public interface Resource extends InputStreamSource {

	/**
     * 用于判断对应的资源是否真的存在
	 */
	boolean exists();

	/**
     * 用于判断对应资源的内容是否可读。需要注意的是当其结果为 true 的时候，
	 * 其内容未必真的可读，但如果返回false，则其内容必定不可读
	 */
	default boolean isReadable() {
		return exists();
	}

	/**
     * 用于判断当前资源是否代表一个已打开的输入流，如果结果为true，则表示当前资源的输入流不可被多次读取，
	 * 而且在读取以后需要对他进行关闭，以防止内存泄漏。
	 * 该方法主要针对于 InputStreamResource ，实现类中只有它的返回结果为true ,其他都为false
	 */
	default boolean isOpen() {
		return false;
	}

	/**
     * 是否为 File
	 */
	default boolean isFile() {
		return false;
	}

	/**
	 * URL和URI的异同可以看这篇文章：https://segmentfault.com/a/1190000006081973
     * 返回资源的 URL
	 */
	URL getURL() throws IOException;

	/**
     * 返回资源的 URI
	 * URL和URI都是为了获取网络文件的路径，并去加载该文件
	 * 如果当前资源不能解析为一个URL则会抛出异常
	 */
	URI getURI() throws IOException;

	/**
     * 返回当前资源对应的File实例
	 */
	File getFile() throws IOException;

	/**
     * 返回 一个从给定流(getInputStream)读取字节的通道
	 * 关于ReadableByteChannel 可以查看 https://www.cnblogs.com/chenpi/p/6481271.html
	 */
	default ReadableByteChannel readableChannel() throws IOException {
		return Channels.newChannel(getInputStream());
	}

	/**
     * 资源内容的长度
	 */
	long contentLength() throws IOException;

	/**
     * 资源最后的修改时间
	 */
	long lastModified() throws IOException;

	/**
     * 根据资源的相对路径创建新资源
	 */
	Resource createRelative(String relativePath) throws IOException;

	/**
     * 资源的文件名
	 */
	@Nullable
	String getFilename();

	/**
     * 资源的描述
	 */
	String getDescription();

}
